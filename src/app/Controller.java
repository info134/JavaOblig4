package app;
import app.DAOs.DAOAddress;
import app.DAOs.DAOCustomer;
import app.DAOs.DAOProduct;
import app.DAOs.InvoiceDAO;
import app.models.Address;
import app.models.Customer;
import app.models.Invoice;
import app.models.Product;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.util.Iterator;

public class Controller {

    //customer
    @FXML
    private TextField betaltav;
    @FXML
    private TextField kid;
    @FXML
    private TextField betalttil;
    @FXML
    private TextField phonenr;
    @FXML
    private TextField belastk;

    //address
    @FXML
    private TextField vei;
    @FXML
    private TextField postcode;
    @FXML
    private TextField postplace;
    @FXML
    private TextField gatenr;
    @FXML
    private TextField addressID;

    //product
    @FXML
    private TextField kroner;
    @FXML
    private TextField PrId;
    @FXML
    private TextField PrName;
    @FXML
    private TextField PrDescription;
    @FXML
    private TextField PrCategory;

    //invoice
    @FXML
    private TextField dato;
    @FXML
    private TextField invoice_ID;

    //iterators of the object types
    private Iterator<Customer> invoiceIterator = new DAOCustomer().findAll().iterator();
    private Iterator<Address> invoiceIterator2 = new DAOAddress().findAll().iterator();
    private Iterator<Product> invoiceIterator3 = new DAOProduct().findall().iterator();
    private Iterator<Invoice> invoiceIterator4 = new InvoiceDAO().getAllInvoicesByCustomer().iterator();


    @FXML
    public void handleSubmitButtonAction(ActionEvent actionEvent) {

        if (invoiceIterator.hasNext()) {

            //if hasNext then next address, customer, product, invoice
            Address currentInvoice2 = invoiceIterator2.next();
            Customer currentInvoice = invoiceIterator.next();
            Product currentInvoice3 = invoiceIterator3.next();
            Invoice currentInvoice4 = invoiceIterator4.next();

            //invoice
            dato.setText(currentInvoice4.getInvoiceDate());
            invoice_ID.setText(String.valueOf(currentInvoice4.getInvoiceID()));

            //customer
            betalttil.setText("Andreas Incorporated");
            betaltav.setText(currentInvoice.getName());
            kid.setText(String.valueOf(currentInvoice.getId()));
            phonenr.setText(String.valueOf(currentInvoice.getPhoneNr()));
            belastk.setText(String.valueOf(currentInvoice.getBillingAcc()));

            //Product
            PrDescription.setText(currentInvoice3.getDescription());
            PrId.setText(String.valueOf(currentInvoice3.getpID()));
            PrCategory.setText(String.valueOf(currentInvoice3.getCategory()));
            kroner.setText(String.valueOf(currentInvoice3.getPrice()));
            PrName.setText(currentInvoice3.getpName());

            //Address
            vei.setText(currentInvoice2.getAddressVei());
            gatenr.setText(String.valueOf(currentInvoice2.getAddressGatenr()));
            postplace.setText((currentInvoice2.getAddressPostplace()));
            postcode.setText(String.valueOf(currentInvoice2.getAddressPostcode()));
            addressID.setText(String.valueOf(currentInvoice2.getAddressId()));

            AreaChartet chart = new AreaChartet();
//            chart.startMe();

        } else {
            System.out.println("Showing the invoices again..");
            invoiceIterator = new DAOCustomer().findAll().iterator();
            invoiceIterator2 = new DAOAddress().findAll().iterator();
            invoiceIterator3 = new DAOProduct().findall().iterator();
            invoiceIterator4 = new InvoiceDAO().getAllInvoicesByCustomer().iterator();
        }
    }


    @FXML
    public void addNewButton(ActionEvent actionevent) {

        //address
        Address address = new Address();
        address.setAddressId(Integer.valueOf(addressID.getText()));
        address.setAddressPostcode(Integer.valueOf(postcode.getText()));
        address.setAddressGatenr(Integer.valueOf(gatenr.getText()));
        address.setAddressPostplace(postplace.getText());
        address.setAddressVei(vei.getText());
        new DAOAddress().addAddress(address); //return?

        //product
        Product product = new Product();
        product.setpID(Integer.valueOf(kid.getText()));
        product.setCategory(Integer.valueOf(PrCategory.getText()));
        product.setPrice(Integer.valueOf(kroner.getText()));
        product.setDescription(PrDescription.getText());
        product.setpName(PrName.getText());
        new DAOProduct().addProduct(product);

        //customer
        Customer customer = new Customer();
        customer.setId(Integer.valueOf(kid.getText()));
        customer.setBillingAcc(Long.valueOf(belastk.getText()));
        customer.setPhoneNr(Integer.valueOf(phonenr.getText()));
        customer.setName((betaltav.getText()));
        new DAOCustomer().addCustomer(customer);

        //invoice
        Invoice invoice = new Invoice();
        invoice.setInvoiceID((Integer.valueOf(invoice_ID.getText())));
        invoice.setInvoiceDate((dato.getText()));
        new InvoiceDAO().addInvoice(invoice);
    }

    @FXML
    public void deleteButton(ActionEvent actionevent) {

        //address
        Address address = new Address();
        address.setAddressId(Integer.valueOf(addressID.getText()));
        new DAOAddress().deleteAddress(address);

        //product
        Product products = new Product();
        products.setpID(Integer.valueOf(PrId.getText()));
        new DAOProduct().deleteProduct(products);

        //customer
        Customer customers = new Customer();
        customers.setId(Integer.valueOf(kid.getText()));
        new DAOCustomer().deleteCustomer(customers);

        //invoice
        Invoice invoice = new Invoice();
        invoice.setInvoiceID(Integer.valueOf(invoice_ID.getText()));
        new InvoiceDAO().deleteInvoice(invoice);
    }

    public void saveChanges(ActionEvent actionEvent) {

        //address
        Address address = new Address();
        address.setAddressId(Integer.valueOf(addressID.getText()));
        address.setAddressPostcode(Integer.valueOf(postcode.getText()));
        address.setAddressGatenr(Integer.valueOf(gatenr.getText()));
        address.setAddressPostplace(postplace.getText());
        address.setAddressVei(vei.getText());
        new DAOAddress().changeAddress(address); //return?
        String invoiceid = invoice_ID.getText();

        //product
        Product product = new Product();
        product.setpID(Integer.valueOf(kid.getText()));
        product.setCategory(Integer.valueOf(PrCategory.getText()));
        product.setPrice(Integer.valueOf(kroner.getText()));
        product.setDescription(PrDescription.getText());
        product.setpName(PrName.getText());
        new DAOProduct().changeProduct(product);

        //customer
        Customer customer = new Customer();
        customer.setId(Integer.valueOf(kid.getText()));
        customer.setBillingAcc(Long.valueOf(belastk.getText()));
        customer.setPhoneNr(Integer.valueOf(phonenr.getText()));
        customer.setName((betaltav.getText()));
        new DAOCustomer().changeCustomer(customer);

        //invoice
        Invoice invoice = new Invoice();
        invoice.setInvoiceID((Integer.valueOf(invoice_ID.getText())));
        invoice.setInvoiceDate((dato.getText()));
        new InvoiceDAO().changeInvoice(invoice);
    }



}