import React, { useEffect, useState } from 'react';
import axios from 'axios'
import { Card, Button, Spin, Space } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import { addProduct, changeLoad } from './productSlide';
import { useHistory, useLocation } from 'react-router';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    Redirect,
    NavLink
} from "react-router-dom";
import Book from './Book';
import Clothes from './Clothes';
import Shoes from './Shoes';
import { BookItem, ClothesItem, ShoseItem } from './const';
// import store from '../../app/store';



const Product = () => {
    const [dataImg, setDataImg] = React.useState([])
    const [loading, setLoading] = useState(false)
    const location = useLocation();
    const dispatch = useDispatch();
    const history = useHistory()
    const product = useSelector(state => state.products);
    console.log("product", product)
    //    <Switch>
    //        <Route path ={`${location.pathname}/book`} component={Book}></Route>
    //        <Route path ={`${location.pathname}/clothes`} component={Clothes}></Route>
    //        <Route path ={`${location.pathname}/shoes`} component={Shoes}></Route>
    //    </Switch>

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

            <div style={{ display: 'flex', flexWrap: 'wrap', width: '60%', justifyContent: 'center', margin: '0 auto' }}>
                {/* {allProduct.map(item => {
                   if(item.title =="Book"){
                       return
                      { <NavLink to="/product/book">
                          { <div onClick = {() => handleProduct(item)} style = {{width : "100px" , height : "100px" , borderRadius : "8px" , margin : '10px 25px 10px 25px '}}>
                        <img src={item.img} style={{width : '50px' ,height : '50px'}}/>
                        <div>{item.title}</div>
                    </div>}
                       </NavLink>}
                   }
                })} */}
                <NavLink to="/product/book" style={{ textDecoration: 'none', color: 'black' }}><BookItem /></NavLink>
                <NavLink to="/product/clothes" style={{ textDecoration: 'none', color: 'black' }}><ClothesItem /></NavLink>
                <NavLink to="/product/shoes" style={{ textDecoration: 'none', color: 'black' }}><ShoseItem /></NavLink>
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

const allProduct = [
    {
        img: "https://www.adazing.com/wp-content/uploads/2019/02/open-book-clipart-03.png",
        title: "Book"
    },
    {
        img: "https://baabrand.com/wp-content/uploads/2018/12/icon-thiet-ke-linh-vuc-logo-thuong-hieu-thoi-trang-my-pham-lam-dep-spa-baa-brand-1-400x400.png",
        title: "Clothes"
    },
    {
        img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIV5sy3l6UtAQbJC8eb2WnBtcvmzXd-qrIKw&usqp=CAU",
        title: "Shoes"
    }
]
export default Product;