package com.vijay.a33unitconverterproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vijay.a33unitconverterproject.compose.BaseScreen
import com.vijay.a33unitconverterproject.ui.theme._33UnitConverterProjectTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: ConverterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /*val dao = ConverterDatabase.getInstance(this@MainActivity).converterDao
        val repository = ConverterRepositoryIMPL(dao)
        val factory = ConverterViewModelFactory(repository)*/

        setContent {
            _33UnitConverterProjectTheme {
                ParentUI(factory)
            }
        }
    }
}

@Composable
fun ParentUI(factory: ConverterViewModelFactory){
    Scaffold(
        topBar = {CustomAppBar()},
        modifier = Modifier.fillMaxSize(),
        content = { padding ->
            BaseScreen(
                factory = factory,
                modifier = Modifier.padding(padding)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar() {
    TopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    modifier = Modifier
                        .size(48.dp)
                        .fillMaxWidth()
                        .padding(end = 8.dp),
                    painter = painterResource(id = R.drawable.baseline_calculate_24),
                    contentDescription = "Unit Converter",
                    tint = Color.White
                )
                Text(
                    "Unit Converter",
                    color = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary)
    )
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _33UnitConverterProjectTheme {

        ParentUI()
    }
}*/
