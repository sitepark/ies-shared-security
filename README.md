# Shared Security

The shared security package provides central, cross-module security concepts that form a consistent and system-wide security basis for all modules of the IES system.

## Goal and benefits

- Standardization\*\*: Central definition of authentication and authorization models.
- **Consistency**: Clear security standards and centralized security policies.
- Reusability\*\*: Avoidance of redundant security implementations in individual modules.
- Abstraction\*\*: Provision of abstract interfaces for security mechanisms that are independent of specific business logic.

## Design principles

- **Cross-Cutting Concern**: Safety logic that can be used across modules.
- **Abstract definitions**: Exclusively interfaces and abstract classes, no implementations.
