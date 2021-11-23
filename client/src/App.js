import Footer from "./Com/Footer";
import Header from "./Com/Header"
import { routes } from "./router";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  Redirect
} from "react-router-dom";
import Product from "./UI/Product";
import Login from "./UI/Login";
import Contact from "./UI/Contact";
import About from "./UI/About";
import Cart from "./UI/Cart/Cart";
import Book from "./UI/Product/Book";
import Clothes from "./UI/Product/Clothes";
import Shoes from "./UI/Product/Shoes";
import Checkout from "./UI/Checkout";
import { useSelector } from "react-redux";
function App() {
  const product = useSelector(state => state.products);
  const loading = product[0].loading
  console.log("loading" ,loading)
  return (
    <Router>
      <Header />
      <Switch>   
        {
          routes.map(routes => {
            return <Route path={routes.path} component={routes.component} />
          })
        }
      </Switch>
        <Footer />
    </Router>
  );
}


export default App;
