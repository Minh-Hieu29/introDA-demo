import { createSlice } from "@reduxjs/toolkit";

const product = createSlice({
    name: 'product',
    initialState: [{
        id : 0,
        quality: 0
    }],
    reducers: {
        addProduct: (state, action) => {
            console.log("add" ,state)
            state.push(action.payload)
            state[0].quality = state[0].quality + 1
        },
        delProduct : (state , {payload}) => {
            const remove = payload.id
            console.log("12121" , remove)
            state = state.filter(state => state.id !== remove)
        },
        raiseProduct : (state , {payload}) => {
            state = state.map((state , key) => {
                if(state.id == payload.id){
                    state.qua = state.qua +1
                }
                return state
            })
        },
        reduceProduct : (state , {payload}) => {
            state = state.map((state , key) => {
                if(state.id == payload.id){
                    if(state.qua > 1){
                        state.qua = state.qua -1
                    }
                }
                return state
            })
        }
    }
})

const { reducer, actions } = product
export const { addProduct ,delProduct,raiseProduct , reduceProduct } = actions
export default reducer