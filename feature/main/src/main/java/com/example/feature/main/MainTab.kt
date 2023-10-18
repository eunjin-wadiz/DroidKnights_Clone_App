package com.example.feature.main

internal enum class MainTab(
    val iconResId: Int,
    internal val contentDescription: String,
    val route: String
) {
    SETTING(
        iconResId = R.drawable.ic_setting,
        contentDescription = " 설정",
        route = "setting"
    ),
    HOME(
        iconResId = R.drawable.ic_home,
        contentDescription = "홈",
        route = "home"
    ),
    BOOKMARK(
        iconResId = R.drawable.ic_bookmark,
        contentDescription = "북마크",
        route = "bookmark"
    )

}