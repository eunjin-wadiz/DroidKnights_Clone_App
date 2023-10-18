package com.example.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHost
import com.example.core.designsystem.theme.surfaceDim
import com.example.feature.home.navigation.homeNavGraph
import kotlinx.coroutines.launch
import java.net.UnknownHostException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
    onChangeDarkTheme: (Boolean) -> Unit
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val localContextResource = LocalContext.current.resources
    val onShowErrorSnackBar: (throwable: Throwable?) -> Unit = { throwable ->
        coroutineScope.launch {
            snackBarHostState.showSnackbar(
                when (throwable) {
                    is UnknownHostException -> localContextResource.getString(R.string.error_message_network)
                    else -> localContextResource.getString(R.string.error_message_unknown)
                }
            )
        }
    }


    Scaffold(
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceDim)
            ) {
                NavHost(
                    navController = navigator.navController,
                    startDestination = navigator.startDestination
                ) {
                    homeNavGraph(
                        padding = padding,
                        onSessionClick = {

                        },
                        onContributorClick = {

                        },
                        onShowErrorSnackBar = onShowErrorSnackBar
                    )
                }
            }
        },
        bottomBar = {

        },
        snackbarHost = {
            SnackbarHost(snackBarHostState)
        }
    )

}