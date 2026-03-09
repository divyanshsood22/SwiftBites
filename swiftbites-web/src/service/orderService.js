import axios from "axios";

const API_URL = "http://localhost:8080/api/orders";

export const fetchUserOrders = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error("Error while fetching orders", error);
        throw error;
    }
};

export const createOrder = async (orderData) => {
    try {
        const response = await axios.post(API_URL, orderData);
        return response.data;
    } catch (error) {
        console.error("Error while creating order", error);
        throw error;
    }
};

export const deleteOrder = async (orderId) => {
    try {
        await axios.delete(API_URL + "/" + orderId);
        return true;
    } catch (error) {
        console.error("Error while deleting order", error);
        return false;
    }
};