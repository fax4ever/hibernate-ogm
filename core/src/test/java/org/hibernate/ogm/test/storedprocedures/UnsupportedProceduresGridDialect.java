/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.test.storedprocedures;

import org.hibernate.ogm.datastore.spi.DatastoreProvider;
import org.hibernate.ogm.dialect.spi.AssociationContext;
import org.hibernate.ogm.dialect.spi.AssociationTypeContext;
import org.hibernate.ogm.dialect.spi.BaseGridDialect;
import org.hibernate.ogm.dialect.spi.ModelConsumer;
import org.hibernate.ogm.dialect.spi.NextValueRequest;
import org.hibernate.ogm.dialect.spi.OperationContext;
import org.hibernate.ogm.dialect.spi.TupleAlreadyExistsException;
import org.hibernate.ogm.dialect.spi.TupleContext;
import org.hibernate.ogm.dialect.spi.TupleTypeContext;
import org.hibernate.ogm.entityentry.impl.TuplePointer;
import org.hibernate.ogm.model.key.spi.AssociationKey;
import org.hibernate.ogm.model.key.spi.AssociationKeyMetadata;
import org.hibernate.ogm.model.key.spi.EntityKey;
import org.hibernate.ogm.model.key.spi.EntityKeyMetadata;
import org.hibernate.ogm.model.spi.Association;
import org.hibernate.ogm.model.spi.Tuple;

/**
 * Only used to test error messages when a dialect doesn't support server side procedure calls.
 *
 * @see UnsupportedProceduresGridDialect
 * @author Davide D'Alto
 */
public class UnsupportedProceduresGridDialect extends BaseGridDialect {

	public UnsupportedProceduresGridDialect(DatastoreProvider provider) {
	}

	@Override
	public Tuple getTuple(EntityKey key, OperationContext operationContext) {
		return null;
	}

	@Override
	public Tuple createTuple(EntityKey key, OperationContext operationContext) {
		return null;
	}

	@Override
	public void insertOrUpdateTuple(EntityKey key, TuplePointer tuplePointer, TupleContext tupleContext) throws TupleAlreadyExistsException {
	}

	@Override
	public void removeTuple(EntityKey key, TupleContext tupleContext) {
	}

	@Override
	public Association getAssociation(AssociationKey key, AssociationContext associationContext) {
		return null;
	}

	@Override
	public Association createAssociation(AssociationKey key, AssociationContext associationContext) {
		return null;
	}

	@Override
	public void insertOrUpdateAssociation(AssociationKey key, Association association, AssociationContext associationContext) {
	}

	@Override
	public void removeAssociation(AssociationKey key, AssociationContext associationContext) {
	}

	@Override
	public boolean isStoredInEntityStructure(AssociationKeyMetadata associationKeyMetadata, AssociationTypeContext associationTypeContext) {
		return false;
	}

	@Override
	public Number nextValue(NextValueRequest request) {
		return null;
	}

	@Override
	public void forEachTuple(ModelConsumer consumer, TupleTypeContext tupleTypeContext, EntityKeyMetadata entityKeyMetadata) {
	}
}
