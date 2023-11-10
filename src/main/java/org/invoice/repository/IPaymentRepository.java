package org.invoice.repository;

import org.invoice.models.IPaymentMethod;

public interface IPaymentRepository {
    long savePayment(IPaymentMethod paymentMethod);

    IPaymentMethod getPayment(String paymentID);
}
