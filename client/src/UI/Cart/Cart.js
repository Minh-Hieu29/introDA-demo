import React, { useState } from 'react';
import { Button } from 'antd';
import { useSelector } from 'react-redux';
import CartIteam from './CartItem';
const Cart = () => {

    const items = {
        category: "men's clothing",
        description: "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
        id: 1,
        image: "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        price: 109.95,
        rating: { rate: 3.9, count: 120 },
        title: "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
    }
    const productCart = useSelector(state => state.products)
    var total = 0
    const handleAdd = (data) => {
        console.log("data", data)
    }

    const element = productCart.map((item, key) => {
        if (key > 0) {
            total = total + item.price * item.qua
            return <CartIteam items={item} handleAdd={(data) => console.log("data", data)} />
        }
    })
    console.log("total", total)
    return (
        <div style={{ backgroundColor: "#EEEEEE", borderRadius: '5px', maxWidth: '70%', margin: '0 auto' }}>
            {element}
            <div style={{ display: 'flex', justifyContent: 'flex-end' }}>
                <div>
                    {total}
                </div>
                <Button>
                    Mua hàng
                </Button>
            </div>
        </div>
    );
};

export default Cart;