package id.ac.unhas.infocovid19.model

import android.content.Context
import com.google.gson.Gson
import java.io.IOException

class DataSourceHarian {
    companion object{
        fun createDataSet(jsonString: String): DataHarian{

            val gson = Gson()
            val data: DataHarian = gson.fromJson(jsonString, DataHarian::class.java)

            return data
        }

        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}