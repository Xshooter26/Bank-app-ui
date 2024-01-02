package com.example.bankingappui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.data.Finance
import com.example.bankingappui.ui.theme.BlueStart
import com.example.bankingappui.ui.theme.GreenStart
import com.example.bankingappui.ui.theme.OrangeStart
import com.example.bankingappui.ui.theme.PurpleStart


val financeList = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        background = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.Money,
        name = "Finance\nAnalytics",
        background = PurpleStart
    ), Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "Finance\nTransAction",
        background = GreenStart
    )
)

@Composable
fun FinanceSection() {

    Column {
        // "Finance" Heading
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)

        )

        LazyRow {
            items(financeList.size) {
                financeItem(it)
            }
        }

    }

}

@Composable
fun financeItem(index: Int) {

    val finance = financeList[index]
    var lastPadding = 0.dp
    if (index == financeList.size - 1) {
        lastPadding = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp,end = lastPadding)){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .size(120.dp)
            .clickable { }
            .padding(16.dp), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(14.dp))
                .background(finance.background)
                .padding(6.dp)
        ) {
            Icon(imageVector = finance.icon, contentDescription = null, tint = Color.White)
        }

        Text(
            text = finance.name,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            fontWeight = FontWeight.SemiBold
        )

    }
}

}
