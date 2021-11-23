import React, { useEffect, useState } from 'react';
import axios from 'axios'
import { Card, Button, Spin, Space } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import { addProduct, changeLoad } from '../productSlide';
import { useHistory, useLocation } from 'react-router';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    Redirect,
    NavLink
} from "react-router-dom";
import { BookItem, ClothesItem, ElectronicItem, ShoseItem } from '../const';

const Book = () => {
    const [dataImg, setDataImg] = React.useState([])
    const [loading, setLoading] = useState(false)
    const location = useLocation();
    const dispatch = useDispatch();
    const history = useHistory()
    const product = useSelector(state => state.products);
    console.log("product", product)

    const _requestData = async (param = {}) => {
        setLoading(true)
        const data = await axios.get("https://fakestoreapi.com/products")
        setLoading(false)
        console.log("data", data)
        const dataConvert = data.data.map(i => {
            i.qua = 1
            return i
        })
        setDataImg([...dataConvert])
    }

    useEffect(() => {

        _requestData()
    }, [])

    const handleClick = (data) => {
        if (!product[0].loading) {
            history.push('/login')
        }
        else {
            const action = addProduct(data)
            dispatch(action)
        }
    }
    // const productCart = useSelector(state => state.products)
    const handleProduct = (item) => {
        console.log("pro", item)
        if (item.title == "Book") {

        }

    }
    // console.log("prC", productCart)
    const { Meta } = Card;
    return (
        <div>
            <div style = {{display: 'flex', flexWrap: 'wrap', width: '60%', justifyContent: 'center', margin: '0 auto'}}>
               {/* <NavLink to="/product/book" style={{textDecoration : 'none' ,color : 'black'}}><BookItem /></NavLink> */}
               <NavLink to="/product/clothes" style={{textDecoration : 'none' ,color : 'black'}}><ClothesItem /></NavLink>
               <NavLink to="/product/shoes" style={{textDecoration : 'none' ,color : 'black'}}><ShoseItem /></NavLink>
               <NavLink to="/product/electronic" style={{ textDecoration: 'none', color: 'black' }}><ElectronicItem /></NavLink>
            </div>
            {loading ? <Space size="middle" style={{ display: 'flex', justifyContent: 'center' }}>
                <Spin size="small" />
                <Spin />
                <Spin size="large" />
            </Space> : ""}
            <div style={{ display: 'flex', flexWrap: 'wrap', width: '80%', justifyContent: 'center', margin: '0 auto', backgroundColor: "#EEEEEE", borderRadius: '5px' }}>
                {
                    dataImg.map(data => {
                        return <Card
                            hoverable
                            style={{ margin: '30px 40px 30px 40px' }}
                            cover={<img alt="example" src={data.image} style={{ width: "80px", height: "100px" }} />}
                        >
                            <div>
                                Price : <span>{data.price}</span>
                            </div>
                            <div style={{ display: 'flex' }}>
                                <Button type="primary" onClick={() => handleClick(data)}>
                                    Mua hàng
                                </Button>
                                <Button>
                                    Thêm giỏ hàng
                                </Button>
                            </div>
                        </Card>
                    })
                }

            </div>
        </div>
    );
};

export default Book;