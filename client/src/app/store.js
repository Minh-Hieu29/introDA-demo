import { configureStore } from "@reduxjs/toolkit";
import productReducer from "../UI/Product/productSlide"

const rootReducer = {
    products: productReducer
}

const store = configureStore({
    reducer: rootReducer
})

export default store