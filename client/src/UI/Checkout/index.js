import React, { useState } from 'react';
import { useSelector } from 'react-redux';
import 'antd/dist/antd.css'
import { NavLink } from 'react-router-dom';
import { Button, notification } from 'antd';
import { SmileOutlined } from '@ant-design/icons'
import CartIteam from '../Cart/CartItem';
const Checkout = () => {
    const productCart = useSelector(state => state.products)
    var total = 0
    const element = productCart.map((item, key) => {
        if (key > 0) {
            total = total + item.price * item.qua
            return <CartIteam items={item} />
        }
    })
    const openNotification = () => {
        notification.open({
            message: 'Đặt hàng thành công',
            description:
                'Chúc bạn mua hàng vui vẻ',
            icon: <SmileOutlined style={{ color: '#108ee9' }} />,
        });
    };
    return (
        <div style={{ backgroundColor: "#EEEEEE", borderRadius: '5px', maxWidth: '70%', margin: '0 auto' }}>
            {element}
            <div style={{ display: 'flex', justifyContent: 'flex-end' }}>
                <div>
                    {total}
                </div>
                <Button type="primary" onClick={openNotification}>
                    Dat hang
                </Button>
            </div>
        </div>
    );
};

export default Checkout;