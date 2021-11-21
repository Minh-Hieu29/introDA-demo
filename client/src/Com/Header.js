import React from 'react';

import { Button, Tooltip, Image, Input } from 'antd';
import { SearchOutlined, QqOutlined, ShoppingCartOutlined, UnorderedListOutlined, CloseOutlined } from '@ant-design/icons';
import { Link } from 'react-router-dom';
import './css/Header.css'
import useSelection from 'antd/lib/table/hooks/useSelection';
import { useSelector } from 'react-redux';
function Header(props) {
    const quality = useSelector(state => state.products)

    return (
        <header>
            <div className="menu">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnXcq_Y-X6lcIl0WM2nmlAbq1ZI9Enhr20G3_ruymLm7BLCZJnwyEZpBFjQt_Ae1a9vE0&usqp=CAU" style={{ width: "100" }} />
            </div>
            <div className="logo">
                <Link to="/" >
                    <img src="https://thumbs.dreamstime.com/b/vector-text-shop-now-print-sketched-typography-as-label-online-website-promotion-banner-blogger-girl-clothes-souvenir-shoes-115894179.jpg" style={{ width: "100px", borderRadius: "10px" }} />
                </Link>

            </div>
            <nav>
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/product">Product</Link></li>
                    <li><Link to="/contact">Contact</Link></li>
                    <li><Link to="/about">About</Link></li>
                    <li><Link to="/login">Login / Register</Link></li>
                    <li className="close">
                        <CloseOutlined />
                    </li>
                </ul>
                <div className="nav-cart"  >
                    <div>
                        {quality[0].quality}
                    </div>
                    <Link to="/cart">
                        <ShoppingCartOutlined style={{ fontSize: '25px' }} />
                    </Link>
                </div>
            </nav>
        </header>
    );
}

export default Header;