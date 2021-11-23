import React, { useState } from 'react';
import { Form, Input, Button, Checkbox, notification, message } from 'antd';
import { UserOutlined, LockOutlined, CheckOutlined,CloseCircleOutlined } from '@ant-design/icons';
import "./index.css"
import { useDispatch } from 'react-redux';
import { useHistory } from 'react-router';

const Register = () => {
    const [check, setCheck] = useState(false)
    const dispatch = useDispatch()
    const history = useHistory()
    const onFinish = (values) => {
        console.log("valllll", values)
        if (values.check_password == values.password) {
            // const local = localStorage.getItem("User")
            // console.log("local", JSON.parse(local))

            // setCheck(true)
            openNotification()
            localStorage.setItem("User", JSON.stringify(values))
            history.push("/login")
        }
        if(values.check_password !== values.password){
            openNotification1()
        }
    };
    const openNotification = () => {
        notification.open({
            message: 'Đăng ký thành công',
            icon: <CheckOutlined style={{ color: '#108ee9' }} />,
            description : 'Bạn hãy đăng nhập để mua hàng'
        });
    };const openNotification1 = () => {
        notification.open({
            message: 'Đăng ký thất bại',
            icon: <CloseCircleOutlined style={{ color: 'red' }} />,
            description : "Mật khẩu không hợp lệ"
        });
    };
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
            <Form.Item
                name="check_password"
                rules={[{ required: true, message: 'Please input your Password!' },
                ]}
            >
                <Input.Password
                    prefix={<LockOutlined className="site-form-item-icon" />}
                    type="password"
                    placeholder="Check Password"
                />
            </Form.Item>
            <Form.Item>
                {/* <Button type="primary" htmlType="submit" className="login-form-button" style={{margin : '0 10px'}}>
          Log in
        </Button> */}
                <Button type="ghost" htmlType="submit" className="login-form-button">
                    Register
                </Button>
            </Form.Item>
        </Form>
    );
};



export default Register;