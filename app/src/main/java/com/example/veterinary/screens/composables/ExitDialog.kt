package com.example.veterinary.screens.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun ExitDialog(onDismiss: () -> Unit, onConfirmExit: () -> Unit) {

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Kilépés megerősítése") },
        text = { Text(text = "Biztosan ki szeretne lépni?") },
        confirmButton = {
            TextButton(onClick = { onConfirmExit()  }) {
                Text("Igen")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Nem")
            }
        }
    )

}