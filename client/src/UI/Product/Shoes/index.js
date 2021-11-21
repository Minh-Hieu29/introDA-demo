import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    Redirect,
    NavLink
  } from "react-router-dom";
import { BookItem, ClothesItem, ShoseItem } from '../const';
const Shoes = () => {
    return (
        <div>
            <div style = {{display: 'flex', flexWrap: 'wrap', width: '60%', justifyContent: 'center', margin: '0 auto'}}>
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
               <NavLink to="/product/book" style={{textDecoration : 'none' ,color : 'black'}}><BookItem /></NavLink>
               <NavLink to="/product/clothes" style={{textDecoration : 'none' ,color : 'black'}}><ClothesItem /></NavLink>
               <NavLink to="/product/shoes" style={{textDecoration : 'none' ,color : 'black'}}><ShoseItem /></NavLink>
            </div>
            Shoes
        </div>
    );
};

export default Shoes;