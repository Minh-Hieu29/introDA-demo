import Footer from "./Com/Footer";
import Header from "./Com/Header"
import { routes } from "./router";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Product from "./UI/Product";
import Login from "./UI/Login";
import Contact from "./UI/Contact";
import About from "./UI/About";
import Cart from "./UI/Cart/Cart";
import Book from "./UI/Product/Book";
import Clothes from "./UI/Product/Clothes";
import Shoes from "./UI/Product/Shoes";
function App() {
  return (
    <Router>
      <Header />
      <Switch>
      <Route path ="/product/book" component={Book}></Route>
      <Route path ="/product/clothes" component={Clothes}></Route>
      <Route path ="/product/shoes" component={Shoes}></Route>
       {/* <Route path ={`${location.pathname}/clothes`} component={Clothes}></Route>
       <Route path ={`${location.pathname}/shoes`} component={Shoes}></Route> */}
        <Route path="/product" component={Product} />
        <Route path="/about" component={About} />
        <Route path="/contact" component={Contact} />
        <Route path="/login" component={Login} />
        <Route path="/cart" component={Cart} />
      </Switch>
      <Footer />
    </Router>
  );
}

// function RouteWithSubRoutes(route) {
//   return (
//     <Route
//       path={route.path}
//       render={props => (
//         // pass the sub-routes down to keep nesting
//         <route.component {...props} routes={route.routes} />
//       )}
//     />
//   );
// }
export default App;
