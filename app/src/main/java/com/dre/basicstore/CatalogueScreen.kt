package com.dre.basicstore

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dre.cart.CartViewModel
import com.dre.catalogue.CatalogueProduct
import com.dre.catalogue.CatalogueViewModel

@Composable
fun CatalogueScreen(
    catalogueViewModel: CatalogueViewModel,
    cartViewModel: CartViewModel,
) = CatalogueScreen(
    loading = catalogueViewModel.loading,
    itemCount = cartViewModel.itemCount,
    categories = catalogueViewModel.categories,
    products = catalogueViewModel.products,
    onProductAdded = cartViewModel::addItem,
    onProductRemoved = cartViewModel::removeItem,
    onCategorySelected = catalogueViewModel::onCategorySelected,
    onLogoutSelected = {
        catalogueViewModel.onLogoutSelected()
        cartViewModel.onLogoutSelected()
    },
    onBackSelected = catalogueViewModel::onBackSelected,
)

@Composable
fun CatalogueScreen(
    loading: Boolean = false,
    itemCount: Int,
    categories: List<String> = emptyList(),
    products: List<CatalogueProduct> = emptyList(),
    onProductAdded: (Int) -> Unit,
    onProductRemoved: (Int) -> Unit,
    onCategorySelected: (id: String) -> Unit,
    onLogoutSelected: (() -> Unit) = { },
    onBackSelected: (() -> Unit) = { },
) {
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = stringResource(id = R.string.catalogue_cart_item_count, itemCount),
            textAlign = TextAlign.End,
        )

        if (products.isEmpty()) {
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable { onLogoutSelected() },
                text = stringResource(id = R.string.catalogue_screen_logout_label),
            )
            CategoryList(
                modifier = Modifier
                    .fillMaxWidth(),
                categories = categories,
                onCategorySelected = onCategorySelected,
            )
        } else {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable { onBackSelected() },
                text = stringResource(id = R.string.catalogue_screen_back_label),
            )
            ProductList(
                modifier = Modifier.fillMaxWidth(),
                products = products,
                onProductAdded = onProductAdded,
                onProductRemoved = onProductRemoved,
            )
        }
    }
    if (loading) {
        CircularProgressIndicator(
            modifier = Modifier.defaultMinSize(48.dp)
        )
    }
}

@Composable
fun CategoryList(
    modifier: Modifier,
    categories: List<String>,
    onCategorySelected: (id: String) -> Unit,
) {
    val state = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = state,
    ) {
        itemsIndexed(
            items = categories,
        ) { _, item ->
            CategoryItem(
                category = item,
                onCategorySelected = { id -> onCategorySelected(id) },
            )
        }
    }
}

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    category: String,
    onCategorySelected: (id: String) -> Unit,
) {
    Text(
        modifier = modifier
            .clickable { onCategorySelected(category) }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        text = category,
    )
}

@Composable
fun ProductList(
    modifier: Modifier,
    products: List<CatalogueProduct>,
    onProductAdded: (Int) -> Unit,
    onProductRemoved: (Int) -> Unit,
) {
    val state = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = state,
    ) {
        itemsIndexed(
            items = products,
        ) { _, item ->
            ProductItem(
                product = item.name,
                productId = item.id,
                onProductAdded = onProductAdded,
                onProductRemoved = onProductRemoved,
            )
        }
    }
}

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: String,
    productId: Int,
    onProductAdded: (Int) -> Unit,
    onProductRemoved: (Int) -> Unit,
) {
    Column {
        Text(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            text = product,
        )
        Row {
            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = { onProductAdded(productId) }
            ) {
                Text(
                    text = stringResource(R.string.catalogue_add_product),
                )
            }
            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = { onProductRemoved(productId) }
            ) {
                Text(
                    text = stringResource(R.string.catalogue_remove_product),
                )
            }
        }
    }
}
