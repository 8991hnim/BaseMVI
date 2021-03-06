package m.tech.basemvi

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_main.*
import m.tech.basemvi.di.main.MainComponent
import m.tech.basemvi.repositories.PostRepository
import m.tech.basemvi.ui.MainStateEvent.GetPostsDoNotSaveDb
import m.tech.basemvi.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {

    val TAG = "AppDebug"

    @Inject
    lateinit var provider: ViewModelProvider.Factory

    lateinit var viewModel: MainViewModel

    override fun inject() {
        (application as BaseApplication).mainComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, provider).get(MainViewModel::class.java)

        subscribeObserver()

        start.setOnClickListener {
            viewModel.setStateEvent(GetPostsDoNotSaveDb())
        }

        stop.setOnClickListener {
            viewModel.cancelActiveJobs()
        }
    }

    private fun subscribeObserver() {
        viewModel.dataState.observe(this, Observer { dataState ->
            Log.d(TAG, "Loading...")

            dataState.error?.let { event ->
                Log.d(TAG, "Error handling... Cancel loading here")
                event.getContentIfNotHandled()?.let {
                    Log.d(TAG, "Error not handled $it")
                }
            }

            dataState.data?.let { viewState ->
                Log.d(TAG, "Data handling... Cancel loading here")
                viewState.posts?.let {
                    Log.d(TAG, "Got posts returned from API, setting to ViewState... ${it.size}")
                    viewModel.setPosts(it)
                }
            }
        })

        viewModel.viewState.observe(this, Observer { viewState ->
            viewState.posts?.let {
                Log.d(
                    TAG,
                    "Got posts returned from DataState, setting to RecyclerView... ${it.size}"
                )
            }
        })
    }

}













