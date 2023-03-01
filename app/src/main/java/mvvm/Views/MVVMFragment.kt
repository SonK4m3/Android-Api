package mvvm.Views

import mvvm.ViewModels.UserViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.MvvmFragmentLayoutBinding

class MVVMFragment: Fragment() {
    private lateinit var viewModel: UserViewModel
    private var binding: MvvmFragmentLayoutBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = MvvmFragmentLayoutBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // observe LiveData
        viewModel.data.observe(viewLifecycleOwner, { data ->
            // update UI
            binding?.textView?.text = data
        })

        // return fragment view
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // fetch data from ViewModel
        viewModel.fetchData()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}