package eu.stratosphere.sopremo.pact;

import eu.stratosphere.nephele.configuration.Configuration;
import eu.stratosphere.pact.common.stub.CoGroupStub;
import eu.stratosphere.sopremo.EvaluationContext;

public abstract class SopremoCoGroup<IK extends PactJsonObject.Key, IV1 extends PactJsonObject, IV2 extends PactJsonObject, OK extends PactJsonObject.Key, OV extends PactJsonObject>
		extends CoGroupStub<IK, IV1, IV2, OK, OV> {
	private EvaluationContext context;

	@Override
	public void configure(Configuration parameters) {
		this.context = SopremoUtil.deserialize(parameters, "context", EvaluationContext.class);
	}

	protected EvaluationContext getContext() {
		return this.context;
	}
}
