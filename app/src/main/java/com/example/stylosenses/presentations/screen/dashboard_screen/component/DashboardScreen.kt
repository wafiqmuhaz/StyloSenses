package com.example.stylosenses.presentations.screen.dashboard_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.stylosensess.R
import com.example.stylosenses.presentations.graph.home.ShopHomeScreen
import com.example.stylosenses.presentations.screen.dashboard_screen.DashboardViewModel

@Composable
fun DashboardScreen(
    popularProductState: LazyListState = rememberLazyListState(),
    suggestionProductState: LazyListState = rememberLazyListState(),
    productViewModel: DashboardViewModel = hiltViewModel(),
    navController: NavController,
    onItemClick: (Int) -> Unit
) {

    val state = productViewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
//                .background(color = Color(0xFF4a3298), shape = RoundedCornerShape(10.dp))
                .padding(15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Welcome Back!", color = Color.Black)
            Text(
                "Let’s find your closest\n" +
                        "tailor or laundry!",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Special for you", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "See More", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(15.dp))
//special offer cart
        LazyRow(
            state = popularProductState,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            item {
                ConstraintLayout(
                    modifier = Modifier
                        .width(280.dp)
                        .clip(RoundedCornerShape(20.dp))
                ) {
                    //constrains
                    val (bannerText, bannerImage) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.image_banner_3),
                        contentDescription = "",
                        modifier = Modifier.constrainAs(bannerImage) {}
                    )
                    Column(
                        modifier = Modifier
                            .background(Color(0x8DB3B0B0))
                            .padding(15.dp)
                            .constrainAs(bannerText) {
                                top.linkTo(bannerImage.top)
                                bottom.linkTo(bannerImage.bottom)
                                start.linkTo(bannerImage.start)
                                end.linkTo(bannerImage.end)
                                height = Dimension.fillToConstraints
                                width = Dimension.fillToConstraints
                            }
                    ) {
                        Text(
                            text = "Fashion",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.heightIn(15.dp))
                        Text(text = "85 Brands", color = Color.White)
                    }


                }
            }
            item {
                //second item
                ConstraintLayout(
                    modifier = Modifier
                        .width(280.dp)
                        .clip(RoundedCornerShape(20.dp))
                ) {
                    //constrains
                    val (bannerText2, bannerImage2) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.image_banner_2),
                        contentDescription = "",
                        modifier = Modifier.constrainAs(bannerImage2) {}
                    )
                    Column(
                        modifier = Modifier
                            .background(Color(0x8DB3B0B0))
                            .padding(15.dp)
                            .constrainAs(bannerText2) {
                                top.linkTo(bannerImage2.top)
                                bottom.linkTo(bannerImage2.bottom)
                                start.linkTo(bannerImage2.start)
                                end.linkTo(bannerImage2.end)
                                height = Dimension.fillToConstraints
                                width = Dimension.fillToConstraints
                            }
                    ) {
                        Text(
                            text = "Accessories",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.heightIn(15.dp))
                        Text(text = "15 Brands", color = Color.White)
                    }
                }
            }
        }



        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Find Service", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))


        //popular product
//        LazyRow(
//            state = suggestionProductState,
//            horizontalArrangement = Arrangement.SpaceEvenly, //Arrangement.spacedBy(10.dp),
//            contentPadding = PaddingValues(horizontal = 10.dp)
//        ) {
//            items(state.product!!.size) {
//
//                //favourite state rememberable
//                var favouriteRemember by remember { mutableStateOf(state.product[it].isFavourite) }
//
//                Column {
//                    Box(
//                        modifier = Modifier
//                            .size(150.dp)
//                            .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
//                            .clip(RoundedCornerShape(10.dp))
//                            .clickable {
//                                onItemClick(state.product[it].id)
//                            },
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Image(
//                            painter = painterResource(id = state.product[it].images[0]),
//                            contentDescription = state.product[it].description
//                        )
//                    }
//                    Text(
//                        text = state.product[it].title,
//                        maxLines = 2,
//                        overflow = TextOverflow.Ellipsis,
//                        modifier = Modifier.width(150.dp)
//                    )
//
//
//                    Row(
//                        modifier = Modifier
//                            .width(150.dp)
//                            .fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(
//                            text = "$ ${state.product[it].price}",
//                            fontWeight = FontWeight(600),
//                            color = MaterialTheme.colorScheme.primary
//                        )
//                        Box(
//                            modifier = Modifier
//                                .size(20.dp)
//                                .background(
//                                    MaterialTheme.colorScheme.primary,
//                                    shape = CircleShape
//                                )
//                                .clip(CircleShape)
//                                .clickable {
//                                    favouriteRemember = !favouriteRemember
//                                },
//                            contentAlignment = Alignment.Center
//                        ) {
//
//                            Image(
//                                painter = painterResource(
//                                    id = if (favouriteRemember)
//                                        R.drawable.heart_icon_2
//                                    else R.drawable.heart_icon
//                                ),
//                                contentDescription = "Favourite Icon",
//                                modifier = Modifier.padding(3.dp),
//                                colorFilter = if (favouriteRemember) ColorFilter.tint(
//                                    Color.Red
//                                ) else null
//                            )
//                        }
//                    }
//
//                }
//            }
//        }

        //


//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//                .clickable { navController.navigate("taylor_screen") }
//                .padding(16.dp)
//                .background(Color.Blue)
//        ) {
//            Text(
//                text = "Taylor",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black
//            )
//        }

//
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//                .clickable { navController.navigate("laundry") }
//                .padding(16.dp)
//                .background(MaterialTheme.colorScheme.primary)
//        ) {
//            Text(
//                text = "Laundry",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = MaterialTheme.colorScheme.onPrimary
//            )
//        }
        //

        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            item {
                ConstraintLayout(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(20.dp))
//                        .clickable {navController.navigate(ShopHomeScreen.TailorListScreen.route)}
                ) {
                    //constrains
                    val (bannerText, bannerImage) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.image_banner_3),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.constrainAs(bannerImage) {}
                    )
                    Column(
                        modifier = Modifier
                            .background(Color(0x8DB3B0B0))
                            .padding(15.dp)
                            .constrainAs(bannerText) {
                                top.linkTo(bannerImage.top)
                                bottom.linkTo(bannerImage.bottom)
                                start.linkTo(bannerImage.start)
                                end.linkTo(bannerImage.end)
                                height = Dimension.fillToConstraints
                                width = Dimension.fillToConstraints
                            }
                    ) {
                        Text(
                            text = "Taylor",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.heightIn(15.dp))
                    }


                }
            }

//            Box(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(8.dp)
//                    .background(Color.Blue)
//                    .clickable { navController.navigate(ShopHomeScreen.TaylorScreen.route) }
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = "Taylor",
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White
//                )
//            }

            item {
                //second item
                ConstraintLayout(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable { navController.navigate(ShopHomeScreen.LaundryScreen.route) }
                ) {
                    //constrains
                    val (bannerText2, bannerImage2) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.image_banner_2),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.constrainAs(bannerImage2) {}
                    )
                    Column(
                        modifier = Modifier
                            .background(Color(0x8DB3B0B0))
                            .padding(15.dp)
                            .constrainAs(bannerText2) {
                                top.linkTo(bannerImage2.top)
                                bottom.linkTo(bannerImage2.bottom)
                                start.linkTo(bannerImage2.start)
                                end.linkTo(bannerImage2.end)
                                height = Dimension.fillToConstraints
                                width = Dimension.fillToConstraints
                            }
                    ) {
                        Text(
                            text = "Laundry",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.heightIn(15.dp))
                    }
                }
            }

//            Box(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(8.dp)
//                    .background(Color.Blue)
//                    .clickable { navController.navigate(ShopHomeScreen.LaundryScreen.route) }
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = "Laundry",
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White
//                )
//            }
        }
    }
}