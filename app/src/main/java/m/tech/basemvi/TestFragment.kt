package m.tech.basemvi

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class TestFragment : Fragment(R.layout.fragment_test) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as BaseApplication).mainComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}