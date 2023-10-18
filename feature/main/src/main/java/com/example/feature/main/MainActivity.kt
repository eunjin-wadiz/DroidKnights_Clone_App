package com.example.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.core.designsystem.theme.KnightsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            // val isDarkTheme by viewModel.isDarkTheme.collectAsStateWithLifecycle(false, this)
            //
            // val navigator: MainNavigator = rememberMainNavigator()
            // val sessionId = sessionIdFromWidget.collectAsStateWithLifecycle().value

            // LaunchedEffect(sessionId) {
            //     sessionId?.let {
            //         navigator.navigateSessionDetail(it)
            //     }
            // }

            KnightsTheme(darkTheme = false) {
                MainScreen() {

                }
                // MainScreen(
                //     navigator = navigator,
                //     onChangeDarkTheme = { isDarkTheme -> viewModel.updateIsDarkTheme(isDarkTheme) }
                // )
            }
        }
    }
}
