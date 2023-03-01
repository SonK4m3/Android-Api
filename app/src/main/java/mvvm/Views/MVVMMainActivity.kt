package mvvm.Views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.MvvmMainActivityLayoutBinding

class MVVMMainActivity : AppCompatActivity() {
    private lateinit var binding: MvvmMainActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MvvmMainActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}