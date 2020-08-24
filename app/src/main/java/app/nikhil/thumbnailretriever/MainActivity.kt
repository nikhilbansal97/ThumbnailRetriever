package app.nikhil.thumbnailretriever

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.ImageLoader
import coil.load
import kotlinx.android.synthetic.main.activity_main.imageView
import okhttp3.HttpUrl

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val imageUrl =
      "https://images.unsplash.com/photo-1542029722221-1c7dc4b06781?ixlib=rb-1.2.1&auto=format&fit=crop&w=1868&q=80"
    val videoUrl = "https://media.us1.twilio.com/ME907829a892cf736c22f7ae5a0c3eba9e?Expires=1598253518&Signature=osCE9llVfmwHm8PWHW~i7f3skPyN60Bu5BqiOEyBlSPyW1u6jSaFFJH5C9NE-jJ-SRkxaWuuGKPfgwOy8m6UmbDOC8FtmTW1Zftt6jTDP02uNCxIE0pJFSmDY7C16qLnOgsgNpgBsr9ukg-vpsIYBiUExqrCtO8VnbaX66ai35i3aJjM2AJH6H5SYRL3Oq1gWs5NiwLq9tUcleDmD3gMNiXpEH8vaQhdhRGGoSfKiSoFi4~aH~2lJbbnatAx9E4EmMCXJWgwzsGWegtwizd-lK~N-muEQ4plu1BQfaKuJ8U6Tqs-dsE0p~sUU0iXmrp8mE63cgi2ADMoVA4dJSxAzA__&Key-Pair-Id=APKAJWF6YVTMIIYOF3AA"

    val imageLoader = ImageLoader.Builder(this)
      .componentRegistry {
        add(VideoFrameNetworkFetcher(context = this@MainActivity))
      }
      .build()

    imageView.load(videoUrl, imageLoader)
  }
}