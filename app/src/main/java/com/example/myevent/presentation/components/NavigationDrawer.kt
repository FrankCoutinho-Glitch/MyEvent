package com.example.myevent.presentation.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.myevent.R
import com.example.myevent.utils.MyButtonsColors
//import com.example.myevent.utils.fontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    onCommunityClicked: () -> Unit,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxWidth(0.7f),
                content = {
                    Spacer(modifier = Modifier.height(32.dp))
                    NavigationDrawerItem(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        label = {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
//                                    .padding(horizontal = 16.dp)
                            ) {

                                Surface(
                                    modifier = Modifier.size(35.dp),
                                    shape = CircleShape,
                                    color = MyButtonsColors.iconBackgroundColor,
                                    tonalElevation = 1.dp
                                ) {
                                    Icon(
                                        modifier = Modifier.padding(5.dp),
                                        imageVector = Icons.Rounded.Settings,
                                        contentDescription = "",
                                        tint = MyButtonsColors.white
                                    )
                                }

                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = stringResource(id = R.string.your_community_button),
                                    style = TextStyle(
                                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
//                                        fontFamily = fontFamily(
//                                            fontWeight = FontWeight.Bold
//                                        ),
                                        color = MyButtonsColors.white,
                                    )
                                )
                            }

                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = MyButtonsColors.buttonColor
                        ),
                        shape = MaterialTheme.shapes.medium,
                        selected = false,
                        onClick = onCommunityClicked
                    )
                }
            )
        },
        content = content
    )
}
