package com.dre.basicstore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dre.auth.AuthViewModel
import com.dre.cart.CartViewModel

@Composable
fun AuthScreen(
    authViewModel: AuthViewModel,
) = AuthScreen(
    loading = authViewModel.loading,
    authError = authViewModel.authError,
    login = authViewModel::login
)

@Composable
fun AuthScreen(
    loading: Boolean,
    authError: Boolean,
    login: (String, String) -> Unit,
) {

    Column {
        var username by rememberSaveable { mutableStateOf("johnd") }
        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            label = { Text(text = stringResource(R.string.auth_screen_username_label)) }
        )

        var password by rememberSaveable { mutableStateOf("m38rmF\$") }
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = stringResource(R.string.auth_screen_password_label)) }
        )

        Button(
            onClick = { login(username, password) }
        ) {
            Text(text = stringResource(R.string.auth_screen_login_label))
        }

        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.defaultMinSize(48.dp)
            )
        }
        if (authError) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(48.dp),
                text = stringResource(id = R.string.auth_screen_auth_error),
            )
        }
    }
}
