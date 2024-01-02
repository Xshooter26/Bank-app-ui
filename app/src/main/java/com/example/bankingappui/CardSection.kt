package com.example.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.data.Card
import com.example.bankingappui.ui.theme.BlueEnd
import com.example.bankingappui.ui.theme.BlueStart
import com.example.bankingappui.ui.theme.GreenEnd
import com.example.bankingappui.ui.theme.GreenStart
import com.example.bankingappui.ui.theme.OrangeEnd
import com.example.bankingappui.ui.theme.OrangeStart
import com.example.bankingappui.ui.theme.Purple40
import com.example.bankingappui.ui.theme.Purple80
import com.example.bankingappui.ui.theme.PurpleEnd
import com.example.bankingappui.ui.theme.PurpleStart


val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3665 8837 8735 2253",
        cardName = "Business",
        balance = 7673.332,
        color = getGradient(PurpleStart, PurpleEnd)
    ),

    Card(
        cardType = "MASTERCARD",
        cardNumber = "3665 7738 8735 2253",
        cardName = "Saving",
        balance = 773.332,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "4929 1023 4567 8901",
        cardName = "Vacation Fund",
        balance = 1245.75,
        color = getGradient(OrangeStart, OrangeStart)
    ),

    Card(
        cardType = "MASTERCARD",
        cardNumber = "3412 987654 32109",
        cardName = "Adventure Card",
        balance = 2890.48,
        color = getGradient(GreenStart, GreenEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "6011 2233 4455 6677",
        cardName = "Dreams & Goals",
        balance = 398.60,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "5555 6789 0123 4567",
        cardName = "Tech Investments",
        balance = 5672.90,
        color = getGradient(Purple80, Purple40)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "4111 2233 3444 5566",
        cardName = "Emergency Fund",
        balance = 1120.35,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}

@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }

    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPadding = 0.dp
    if (index == cards.size - 1) {
        lastItemPadding = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTERCARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }


    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPadding)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp), verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = image,contentDescription = card.cardName,modifier = Modifier.width(60.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = card.cardName,color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Normal)
            Text(text = "$ ${card.balance}",color = Color.White, fontSize = 23.sp, fontWeight = FontWeight.Bold)
            Text(text = card.cardNumber,color = Color.White, fontSize = 19.sp, fontWeight = FontWeight.Bold)




        }
    }
}
