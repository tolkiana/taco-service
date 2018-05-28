package com.tolkiana.taco.tacoservice.resource

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.transfer.TransferManager
import com.amazonaws.services.s3.transfer.TransferManagerBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import java.io.File

@Service
class AwsResourceService(private val objectMapper: ObjectMapper, private val amazonS3: AmazonS3) : ResourceService {

    private val bucket: String = "taco-app"

    override fun uploadProduct(name: String, product: Any) {
        val content = objectMapper.writeValueAsBytes(product)
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = content.size.toLong()
        createTransferManager().upload(bucket, name, content.inputStream(), objectMetadata)
    }

    override fun <T> getProduct(name: String, clazz: Class<T>): T {
        val file = File.createTempFile("product-download-", ".tmp")
        createTransferManager().download(bucket, name, file).waitForCompletion()
        return objectMapper.readValue(file, clazz)
    }

    private fun createTransferManager(): TransferManager {
        val builder = TransferManagerBuilder.standard()
        builder.s3Client = amazonS3
        return builder.build()
    }
}