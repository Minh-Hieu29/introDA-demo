import React from 'react';
import { Button } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import { delProduct, raiseProduct, reduceProduct } from '../../Product/productSlide';
const CartIteam = (items = {} , handleAdd = () => {}) => {
    const dispatch = useDispatch()
    const productCart = useSelector(state => state.products)
    const handleDelItem = (items) => {
        console.log("delll" ,{items ,productCart})
        const newState = productCart.indexOf(items)
        dispatch(delProduct(newState))
    }

    const handleRaise = (items) => {
        console.log("1111" , items)
        const action = raiseProduct(items)
        dispatch(action)
    }
    const handleReduce = (items) => {
        const action = reduceProduct(items)
        dispatch(action)
    }
    
    return (
        <div style = {{display : 'flex' , margin : '30px 0px' ,backgroundColor : "#999999" ,borderRadius : '7px'}}>
            <div style={{ display: 'flex', flex: '1', justifyContent: 'space-around' }}>
                <div>
                    <img src={items.items.image} style={{ maxWidth: '80px', maxHeight: '100px' }} />
                </div>
                <div>
                    {items.items.description}
                </div>
            </div>
            <div style={{ display: 'flex', flex: '1', justifyContent: 'space-around' }}>
                <div> $ {items.items.price}</div>
                <div>
                    Số sản phẩm
                    <span style={{ display: 'flex' }}>
                        <Button onClick = {() => handleRaise(items.items)} style={{ backgroundColor: "silver", width: "30px" }} >+</Button>
                        {items.items.qua}
                        <Button onClick = {() => handleReduce(items.items)} style={{ backgroundColor: "silver", width: "30px" }} >-</Button>
                    </span>
                </div>
            </div>
            <div style={{ display: 'flex', flex: '1', justifyContent: 'space-around' }}>
                <div>
                    $ {items.items.price * items.items.qua}
                </div>
                <div>
                    <Button onClick = {() => handleDelItem(items.items)}>
                        Xoa
                    </Button>
                </div>
            </div>
        </div>
    );
};

export default CartIteam;