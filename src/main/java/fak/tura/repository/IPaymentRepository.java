package fak.tura.repository;

import fak.tura.models.IPaymentMethod;

public interface IPaymentRepository {
    long savePayment(IPaymentMethod paymentMethod);

    IPaymentMethod getPayment(String paymentID);
}
