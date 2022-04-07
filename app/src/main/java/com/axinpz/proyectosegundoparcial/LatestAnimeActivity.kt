package com.axinpz.proyectosegundoparcial

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.net.URL
import java.util.*
import kotlin.properties.Delegates

class FeedEntry {
    var title: String = ""
    var pubDate: String = ""
    var description = ""

    override fun toString(): String {
        return """"
            title = $title
            pubDate = $pubDate
            description = $description
            """.trimIndent()
    }
}

class LatestAnimeActivity : AppCompatActivity() {
    private val TAG = "LatestAnimeActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latest_anime)

        val recyclerView: RecyclerView = findViewById(R.id.xmlRecyclerView)

        Log.d(TAG, "onCreate")

        val downloadData = DownloadData(this, recyclerView)
        downloadData.execute("https://animexinfo.webnode.com/rss/all.xml")
        Log.d(TAG, "onCreate DONE")
    }

    //Companion - Independiente de main activity
    companion object {
        private class DownloadData(context: Context, recyclerView: RecyclerView) : AsyncTask<String, Void, String>(){
            private val TAG = "DownloadData"

            var localContext: Context by Delegates.notNull()
            var localRecyclerView: RecyclerView by Delegates.notNull()

            init {
                localContext = context
                localRecyclerView = recyclerView
            }

            override fun doInBackground(vararg url: String?): String {
                Log.d(TAG, "doInBackground")
                val resFeed = downloadXML(url[0])
                if(resFeed.isEmpty()) {
                    Log.e(TAG, "doInBackground: failed")
                }
                Log.d(TAG, resFeed)
                return resFeed
            }

            //Después de lo que hace doInBackground
            //Revisar el String del parámetro
            override fun onPostExecute(result: String) {
                super.onPostExecute(result)
                Log.d(TAG, "onPostExecute")
                super.onPostExecute(result)
                val parsedApplication = ParseApplication()
                parsedApplication.parse(result)

                //Crea el adaptador
                val adapter: ApplicationsAdapter = ApplicationsAdapter(localContext, parsedApplication.applications)
                localRecyclerView.adapter = adapter
                localRecyclerView.layoutManager = LinearLayoutManager(localContext)
//                for (app in parsedApplication.applications) {
//                    Log.d(TAG, app.toString())
//                }
            }

            //Manda un URL
            private fun downloadXML(urlPath: String?): String {
                return URL(urlPath).readText()
            }
        }
    }
}