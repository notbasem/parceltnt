package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-17T00:10:07+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public ParcelEntity dtoToEntity(Parcel parcel, NewParcelInfo newParcelInfo, TrackingInformation trackingInformation) {
        if ( parcel == null && newParcelInfo == null && trackingInformation == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        if ( parcel != null ) {
            if ( parcel.getWeight() != null ) {
                parcelEntity.setWeight( parcel.getWeight() );
            }
            parcelEntity.setSender( recipientToRecipientEntity( parcel.getSender() ) );
            parcelEntity.setRecipient( recipientToRecipientEntity( parcel.getRecipient() ) );
        }
        if ( newParcelInfo != null ) {
            parcelEntity.setTrackingId( newParcelInfo.getTrackingId() );
        }
        if ( trackingInformation != null ) {
            parcelEntity.setState( trackingInformation.getState() );
            parcelEntity.setVisitedHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getVisitedHops() ) );
            parcelEntity.setFutureHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getFutureHops() ) );
        }

        return parcelEntity;
    }

    protected RecipientEntity recipientToRecipientEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntity recipientEntity = new RecipientEntity();

        recipientEntity.setName( recipient.getName() );
        recipientEntity.setStreet( recipient.getStreet() );
        recipientEntity.setPostalCode( recipient.getPostalCode() );
        recipientEntity.setCity( recipient.getCity() );
        recipientEntity.setCountry( recipient.getCountry() );

        return recipientEntity;
    }

    protected HopArrivalEntity hopArrivalToHopArrivalEntity(HopArrival hopArrival) {
        if ( hopArrival == null ) {
            return null;
        }

        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();

        hopArrivalEntity.setCode( hopArrival.getCode() );
        hopArrivalEntity.setDescription( hopArrival.getDescription() );
        hopArrivalEntity.setDateTime( hopArrival.getDateTime() );

        return hopArrivalEntity;
    }

    protected List<HopArrivalEntity> hopArrivalListToHopArrivalEntityList(List<HopArrival> list) {
        if ( list == null ) {
            return null;
        }

        List<HopArrivalEntity> list1 = new ArrayList<HopArrivalEntity>( list.size() );
        for ( HopArrival hopArrival : list ) {
            list1.add( hopArrivalToHopArrivalEntity( hopArrival ) );
        }

        return list1;
    }
}
