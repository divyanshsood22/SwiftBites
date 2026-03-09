import React, { useEffect, useState } from "react";
import { assets } from "../../assets/assets";
import "./MyOrders.css";
import { fetchUserOrders } from "../../service/orderService";

const MyOrders = () => {
  const [data, setData] = useState([]);

  const fetchOrders = async () => {
    try {
      const response = await fetchUserOrders();
      setData(response);
    } catch (error) {
      console.error("Unable to fetch orders", error);
    }
  };

  useEffect(() => {
    fetchOrders();
  }, []);

  return (
    <div className="container">
      <div className="py-5 row justify-content-center">
        <div className="col-11 card">
          <table className="table table-responsive">
            <tbody>
              {data.map((order) => {
                return (
                  <tr key={order.id}>
                    <td>
                      <img
                        src={assets.delivery}
                        alt=""
                        height={48}
                        width={48}
                      />
                    </td>

                    <td>
                      {order.orderedItems?.map((item, index) =>
                        index === order.orderedItems.length - 1
                          ? `${item.name} x ${item.quantity}`
                          : `${item.name} x ${item.quantity}, `
                      )}
                    </td>

                    <td>&#x20B9;{order.amount?.toFixed(2)}</td>

                    <td>Items: {order.orderedItems?.length || 0}</td>

                    <td className="fw-bold text-capitalize">
                      &#x25cf; {order.orderStatus}
                    </td>

                    <td>
                      <button
                        className="btn btn-sm btn-warning"
                        onClick={fetchOrders}
                      >
                        <i className="bi bi-arrow-clockwise"></i>
                      </button>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default MyOrders;