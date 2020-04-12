package id.ac.unhas.infocovid19.ui.harian

import id.ac.unhas.infocovid19.model.DataHarian
import id.ac.unhas.infocovid19.model.DataSourceHarian
import id.ac.unhas.infocovid19.model.Harian

class HarianRepository(
    private val jsonString: String
) {
    fun getHarianFromJsonString() : ArrayList<Harian>{
        val listHarian = ArrayList<Harian>()
        val dataHarian: DataHarian = DataSourceHarian.createDataSet(jsonString)
        dataHarian.data?.forEach {
            if (it != null) {
                listHarian.add(it)
            }
        }
        return listHarian
    }
}