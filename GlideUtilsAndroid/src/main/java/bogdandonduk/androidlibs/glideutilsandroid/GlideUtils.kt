package bogdandonduk.androidlibs.glideutilsandroid

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import java.lang.ref.WeakReference

class GlideUtils(context: Context) {
    var contextWR: WeakReference<Context> = WeakReference(context)

    companion object {
        private var instance: GlideUtils? = null

        private fun getInstance(context: Context, override: Boolean = false) : GlideUtils {
            if(override || instance == null)
                instance = GlideUtils(context)

            return instance!!
        }
    }

    val bitmapRequestBuilder = Glide.with(contextWR.get()!!)
            .asBitmap()
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.placeholder_image_error)
            .thumbnail(0.5f)
            .priority(Priority.HIGH)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    val gifRequestBuilder = Glide.with(contextWR.get()!!)
        .asGif()
        .placeholder(R.drawable.placeholder_image)
        .error(R.drawable.placeholder_image_error)
        .thumbnail(0.5f)
        .priority(Priority.HIGH)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
}