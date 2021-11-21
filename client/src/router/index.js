import React from 'react';
import Product from "../UI/Product/index"
import About from "../UI/About/index"
import Contact from "../UI/Contact/index"
import Login from "../UI/Login/index"


export const routes = [
    {
        path: "/product",
        component: Product
    },
    {
        path: "/contact",
        component: Contact
    },
    {
        path: 'about',
        component: About
    },
    {
        path: "login",
        component: Login
    }
]