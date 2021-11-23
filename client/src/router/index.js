import React from 'react';
import Product from "../UI/Product/index"
import About from "../UI/About/index"
import Contact from "../UI/Contact/index"
import Login from "../UI/Login/index"
import Cart from '../UI/Cart/Cart';
import Checkout from '../UI/Checkout';
import Book from '../UI/Product/Book';
import Clothes from '../UI/Product/Clothes';
import Shoes from '../UI/Product/Shoes';


export const routes = [
    // {
    //     path : "/",
    //     component : Home
    // },
    {
        path : "/product/book",
        component : Book
    },
    {
        path : "/product/clothes",
        component : Clothes
    },
    {
        path : "/product/shoes",
        component : Shoes
    },
    {
        path: "/product",
        component: Product,
    },
    {
        path: "/contact",
        component: Contact
    },
    {
        path: '/about',
        component: About
    },
    {
        path: "/login",
        component: Login
    },
    {
        path : "/cart",
        component : Cart
    },
    {
        path : "/checkout",
        component : Checkout
    }
]