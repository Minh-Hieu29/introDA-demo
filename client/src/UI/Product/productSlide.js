import { createSlice } from "@reduxjs/toolkit";

const product = createSlice({
    name: 'product',
    initialState: [{
        id : 0,
        quality: 0,
        loading : false
    }],
    reducers: {
        changeLoad : (state ,action) => {
            state[0].loading = true
        },
        addProduct: (state, action) => {
            console.log("add" ,state)
            state.push(action.payload)
            state[0].quality = state[0].quality + 1
        },
        delProduct : (state , {payload}) => {
            state.splice(payload ,1)
            state[0].quality = state[0].quality -1
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
export const { addProduct ,delProduct,raiseProduct , reduceProduct ,changeLoad } = actions
export default reducer