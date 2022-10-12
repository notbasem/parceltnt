package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-12T14:56:18+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public at.fhtw.swen3.persistence.entity.Parcel dtoToEntity(Parcel parcel, NewParcelInfo newParcelInfo, TrackingInformation trackingInformation) {
        if ( parcel == null && newParcelInfo == null && trackingInformation == null ) {
            return null;
        }

        at.fhtw.swen3.persistence.entity.Parcel parcel1 = new at.fhtw.swen3.persistence.entity.Parcel();

        if ( parcel != null ) {
            if ( parcel.getWeight() != null ) {
                parcel1.setWeight( parcel.getWeight() );
            }
            parcel1.setRecipient( recipientToRecipient( parcel.getRecipient() ) );
            parcel1.setSender( recipientToRecipient( parcel.getSender() ) );
        }
        if ( newParcelInfo != null ) {
            parcel1.setTrackingId( newParcelInfo.getTrackingId() );
        }
        if ( trackingInformation != null ) {
            parcel1.setState( trackingInformation.getState() );
        }

        return parcel1;
    }

    @Override
    public Parcel entityToParcelDto(at.fhtw.swen3.persistence.entity.Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        Parcel parcel1 = new Parcel();

        parcel1.setWeight( parcel.getWeight() );
        parcel1.setRecipient( recipientToRecipient1( parcel.getRecipient() ) );
        parcel1.setSender( recipientToRecipient1( parcel.getSender() ) );

        return parcel1;
    }

    protected at.fhtw.swen3.persistence.entity.Recipient recipientToRecipient(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        at.fhtw.swen3.persistence.entity.Recipient recipient1 = new at.fhtw.swen3.persistence.entity.Recipient();

        recipient1.setName( recipient.getName() );
        recipient1.setStreet( recipient.getStreet() );
        recipient1.setPostalCode( recipient.getPostalCode() );
        recipient1.setCity( recipient.getCity() );
        recipient1.setCountry( recipient.getCountry() );

        return recipient1;
    }

    protected Recipient recipientToRecipient1(at.fhtw.swen3.persistence.entity.Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        Recipient recipient1 = new Recipient();

        recipient1.setName( recipient.getName() );
        recipient1.setStreet( recipient.getStreet() );
        recipient1.setPostalCode( recipient.getPostalCode() );
        recipient1.setCity( recipient.getCity() );
        recipient1.setCountry( recipient.getCountry() );

        return recipient1;
    }
}
