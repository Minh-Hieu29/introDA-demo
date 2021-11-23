import React from 'react';
import { Form, Input, Button, Checkbox, notification } from 'antd';
import { UserOutlined, LockOutlined, CheckOutlined,CloseCircleOutlined } from '@ant-design/icons';
import "./index.css"
import { useDispatch } from 'react-redux';
import { changeLoad } from '../Product/productSlide';
import { useHistory } from 'react-router';


const Login = () => {
  const dispatch = useDispatch()
  const history = useHistory()

  const local = JSON.parse(localStorage.getItem("User"))
  console.log("local", local)
  const onFinish = (values) => {
    if (values.username == local.username && values.password == local.password) {
      dispatch(changeLoad())
      openNotification()
      history.push("/product")
    }
    else{
      openNotification1()
    }
  };
  const openNotification1 = () => {
    notification.open({
      message: 'Đăng nhập thất bại',
      icon: <CloseCircleOutlined style={{ color: 'red' }} />,
    });
  };
  const openNotification = () => {
    notification.open({
      message: 'Đăng nhập thành công',
      icon: <CheckOutlined style={{ color: '#108ee9' }} />,
    });
  }
  return (
    <Form
      name="normal_login"
      className="login-form"
      initialValues={{ remember: true }}
      onFinish={onFinish}
      style={{ maxWidth: '40%', margin: '0 auto' }}
    >
      <Form.Item
        name="username"
        rules={[{ required: true, message: 'Please input your Username!' }]}
      >
        <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Username" />
      </Form.Item>
      <Form.Item
        name="password"
        rules={[{ required: true, message: 'Please input your Password!' }]}
      >
        <Input.Password
          prefix={<LockOutlined className="site-form-item-icon" />}
          type="password"
          placeholder="Password"
        />
      </Form.Item>
      <Form.Item>
        <Form.Item name="remember" valuePropName="checked" noStyle>
          <Checkbox>Remember me</Checkbox>
        </Form.Item>
      </Form.Item>

      <Form.Item>
        <Button type="primary" htmlType="submit" className="login-form-button" style={{ margin: '0 10px' }}>
          Log in
        </Button>
        <Button type="ghost" className="login-form-button" onClick={() => history.push("./register")}>
          Register
        </Button>
      </Form.Item>
    </Form>
  );
};



export default Login;