package id.ac.unhas.infocovid19.ui.harian

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.unhas.infocovid19.BuildConfig
import id.ac.unhas.infocovid19.R
import id.ac.unhas.infocovid19.model.*
import id.ac.unhas.infocovid19.network.ApiEndPointHarian
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.android.synthetic.main.harianlist_fragment.recyclerview


class HarianListFragment : Fragment() {

    companion object {
        fun newInstance() = HarianListFragment()
    }

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.harianlist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()

        var apiEndPoint = retrofit.create(ApiEndPointHarian::class.java)

        apiEndPoint.getDataHarian().enqueue(object : Callback<DataHarian> {
            override fun onFailure(call: Call<DataHarian>, t: Throwable) {
                Log.e(this::class.java.simpleName, "Error: ${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<DataHarian>, response: Response<DataHarian>) {
                val dataHarian = response.body()?.data

                recyclerview.adapter= HarianAdapter(dataHarian as ArrayList<Harian>)

                Log.d("Hasil Parsing Retrofit", response.body().toString())

            }
        })
        Log.d("MainFragment", "createView")

        linearLayoutManager =LinearLayoutManager(context)
        recyclerview.layoutManager = linearLayoutManager
    }

}