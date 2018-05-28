package com.tolkiana.taco.tacoservice.resource

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.transfer.TransferManager
import com.amazonaws.services.s3.transfer.TransferManagerBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import com.tolkiana.taco.tacoservice.dto.Product
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File

@Service
class AwsResourceService(private val objectMapper: ObjectMapper, private val amazonS3: AmazonS3) : ResourceService {

    @Value("\${cloud.aws.bucket}")
    private lateinit var bucket: String

    override fun uploadProducts(name: String, product: List<Product>) {
        val content = objectMapper.writeValueAsBytes(product)
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = content.size.toLong()
        createTransferManager().upload(bucket, name, content.inputStream(), objectMetadata)
    }

    override fun getProducts(name: String): List<Product> {
        val file = File.createTempFile("product-download-", ".tmp")
        createTransferManager().download(bucket, name, file).waitForCompletion()
        val listType = objectMapper.typeFactory
                .constructCollectionType(List::class.java, Product::class.java)
        return objectMapper.readValue(file, listType)
    }

    private fun createTransferManager(): TransferManager {
        val builder = TransferManagerBuilder.standard()
        builder.s3Client = amazonS3
        return builder.build()
    }
}