package com.example.cartodeaniversrio

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartodeaniversrio.R.*
import com.example.cartodeaniversrio.ui.theme.CartãoDeAniversárioTheme
import com.google.android.filament.Box

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartãoDeAniversárioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CartaodeAniversarioImagem(mensagem = stringResource(string.parabens_texto), destinatario = stringResource(string.assinatura_texto) )
                }
            }
        }
    }
}

@Composable
fun CartaodeAniversaroTexto(mensagem: String,
                            destinatario: String,
                       modifier: Modifier = Modifier){
    Column( modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(modifier = Modifier.padding(top = 0.dp, end = 0.dp, bottom = 0.dp, start = 0.dp),
            text = mensagem,
            fontSize = 36.sp ,
            color = Color.Red,

        )
        Text(modifier =Modifier.padding(top = 90.dp, end = 16.dp, bottom = 0.dp, start = 0.dp)
                                .align(alignment = Alignment.End),

            text = destinatario,
            fontSize = 24.sp,
            color = Color.Black
        )
    }
}

@Composable
fun CartaodeAniversarioImagem(mensagem: String,
                              destinatario: String,
                              modifier : Modifier = Modifier){

    val image = painterResource(drawable.androidparty)//cria a variavel imagem e mostra o endereço onde a imagem está

    Box{
       Image(painter = image, //"pinta" a imagem com a imagem armazenada
        contentDescription = null, //descrição do conteudo é null
        contentScale = ContentScale.Crop
       )
        CartaodeAniversaroTexto(mensagem = mensagem, destinatario =destinatario )
   }

}


@Preview(showBackground = true)
@Composable
fun CartaoAniversarioPreview() {

    CartãoDeAniversárioTheme {
        CartaodeAniversarioImagem(mensagem =stringResource(string.parabens_texto), destinatario =stringResource(string.assinatura_texto))
        //CartaodeAniversaroTexto(destinatario = "- F.Ryan",mensagem = "Parabens Pessoa, Muitos Anos de vida!" )
    }
}