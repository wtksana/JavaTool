package com.wt.JavaTools.util

import com.wt.JavaTools.model.ConfigModel
import java.io.File
import java.io.FileOutputStream
import java.util.*

/**
 * Created by wt on 2017/5/21.
 */
object PropertiesUtil {

    fun getProperties(): List<String> {
        try {
            val dir = File("generator")
            if (!dir.exists()) {
                dir.mkdir()
                return arrayListOf()
            }
            return dir.list().toList()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return arrayListOf()
    }


    fun loadProperty(name: String): Properties {
        val properties = Properties()
        try {
            val dir = File("generator")
            if (!dir.exists()) {
                dir.mkdir()
            }
            val file = File(dir, name)
            if (!file.exists()) {
                file.createNewFile()
            }
            properties.load(file.inputStream())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return properties
    }

    fun saveProperty(configModel: ConfigModel, name: String): String {
        try {
            val properties = Properties()
            properties.setProperty("ip", configModel.ip.value.orEmpty())
            properties.setProperty("dataBase", configModel.dataBase.value.orEmpty())
            properties.setProperty("rootUser", configModel.rootUser.value.orEmpty())
            properties.setProperty("password", configModel.password.value.orEmpty())
            properties.setProperty("tableName", configModel.tableName.value.orEmpty())
            properties.setProperty("entityName", configModel.entityName.value.orEmpty())
            properties.setProperty("packageName", configModel.packageName.value.orEmpty())
            val dir = File("generator")
            if (!dir.exists()) {
                dir.mkdir()
            }
            val file = File(dir, "$name.properties")
            if (!file.exists()) {
                file.createNewFile()
            }
            val out = FileOutputStream(file)
            properties.store(out, null)
            out.flush()
            out.close()
            return "操作成功"
        } catch (e: Exception) {
            return e.message.orEmpty()
        }
    }
}