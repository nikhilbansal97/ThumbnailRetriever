package app.nikhil.thumbnailretriever

import android.content.Context
import android.media.MediaMetadataRetriever
import androidx.core.graphics.drawable.toDrawable
import coil.bitmap.BitmapPool
import coil.decode.DataSource.NETWORK
import coil.decode.Options
import coil.fetch.DrawableResult
import coil.fetch.FetchResult
import coil.fetch.Fetcher
import coil.size.Size
import okhttp3.HttpUrl

class VideoFrameNetworkFetcher(private val context: Context) : Fetcher<HttpUrl> {

  override suspend fun fetch(
    pool: BitmapPool,
    data: HttpUrl,
    size: Size,
    options: Options
  ): FetchResult {

    val retriever = MediaMetadataRetriever()
    retriever.setDataSource(data.toString(), mutableMapOf())
    val bitmap = retriever.getFrameAtTime(1000, MediaMetadataRetriever.OPTION_NEXT_SYNC)
    return DrawableResult(bitmap!!.toDrawable(context.resources), false, NETWORK)
  }

  override fun key(data: HttpUrl): String? = data.encodedPath()
}