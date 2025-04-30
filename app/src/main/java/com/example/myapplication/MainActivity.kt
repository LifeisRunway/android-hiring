package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.network.SocketManager
import com.example.myapplication.ui.screens.GenderAgeScreen
import com.example.myapplication.utils.PrefsManager
import com.example.myapplication.utils.asBoolean
import com.example.myapplication.utils.asInt
import com.example.myapplication.viewmodel.GenderAgeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel = GenderAgeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PrefsManager.init(this)

        viewModel.isMaleState.value = PrefsManager.isMale.asBoolean()
        viewModel.selectedAge.value = PrefsManager.selectedAge.takeIf { it != -1 }

        setContent {
            GenderAgeScreen.Default(
                username = viewModel.username.value,
                ages = viewModel.ages,
                isMaleState = viewModel.isMaleState.collectAsStateWithLifecycle(),
                onClickGender = { viewModel.isMaleState.value = it },
                selectedAge = viewModel.selectedAge.collectAsStateWithLifecycle(),
                onSelectAge = { viewModel.selectedAge.value = it },
                onClickNext = viewModel::send
            )
        }

        lifecycleScope.launch {
            viewModel.isMaleState.collectLatest {
                it?.let {
                    PrefsManager.isMale = it.asInt()
                }
            }
        }

        lifecycleScope.launch {
            viewModel.selectedAge.collectLatest {
                it?.let {
                    PrefsManager.selectedAge = it
                }
            }
        }

        lifecycleScope.launch {
            viewModel.onSuccess.collectLatest {
                if(it != null) {
                   Toast.makeText(this@MainActivity, if(it) "Success!" else "Not success!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}